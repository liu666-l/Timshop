package com.seckill.timer;

import com.seckill.dao.SeckillSeckillGoodsMapper;
import com.seckill.entity.DateUtil;
import entity.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pojo.SeckillSeckillGoods;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Set;



@Component
public class SeckillGoodsPushTask {

    @Autowired
    private SeckillSeckillGoodsMapper mapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 定时将秒杀商品加载到redis中
     * 秒 分 小时 日 周 月
     */
    @Scheduled(cron = "0/60 * * * * ?")
    public void loadGoodsPushRedis() {
        List<Date> dateMenu = DateUtil.getDateMenus();
        for (Date date : dateMenu) {
            date.setYear(2019-1900);    //2019-6-1 为了方便测试
            date.setMonth(6-1);
            date.setDate(1);
            String dateString = SystemConstants.SEC_KILL_GOODS_PREFIX + DateUtil.data2str(date,"yyyyMMddHH");
            //审核状态
            Example example = new Example(SeckillSeckillGoods.class);
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("status","1");
            criteria.andGreaterThan("stockStockCount",0);
            criteria.andGreaterThanOrEqualTo("startStartTime",date);
            criteria.andLessThan("endEndTime",DateUtil.addDateHour(date,2));
            //排除重复商品
            Set keys = redisTemplate.boundHashOps(dateString).keys();
            if(keys!=null&&keys.size()>0){
                criteria.andNotIn("id",keys);

            }
            //查询数据
            List<SeckillSeckillGoods> seckillGoods=mapper.selectByExample(example);
            for(SeckillSeckillGoods seckillGoods1:seckillGoods){
                System.out.println("商品ID："+seckillGoods1.getId()+"--存入到了Redis");
                redisTemplate.boundHashOps(dateString).put(seckillGoods1.getId(),seckillGoods1);
                redisTemplate.boundListOps("SeckillGoodCountList_"+seckillGoods1.getId()).leftPushAll(getGoodsNumber(seckillGoods1.getStockStockCount(),seckillGoods1.getId()),"1","1","1","1");
            }
        }
    }

    /**
     * 获取秒杀商品数量的数组
     * @return
     * @param num
     */
    public Long[] getGoodsNumber(Integer num,Long id) {
        Long[] arr = new Long[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=id;
        }
        return arr;
    }

}
