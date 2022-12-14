package entity;




public class SystemConstants {
    /**
     * 秒杀商品存储到前缀的KEY
     */
    public static final String SEC_KILL_GOODS_PREFIX="SeckillGoods_";


    /**
     * 存储域订单的hash的大key
     */
    public static final String SEC_KILL_ORDER_KEY="SeckillOrder";

    /**
     * 用户排队的队列的KEY
     */
    public static final String SEC_KILL_USER_QUEUE_KEY="SeckillOrderQueue";


    /**
     * 秒杀商品的队列
     */
    public static final String SEC_KILL_GOODS_COUNT_LIST = "SeckillGoodsCountList_";


    /**
     * 用户排队标识的key (用于存储 谁 买了什么商品 以及抢单的状态)
     */
    public static final String SEC_KILL_USER_STATUS_KEY = "UserQueueStatus";

    /**
     * 记录用户排队的次数
     */
    public static final String SEC_KILL_USER_QUEUE_COUNT = "UserQueueCount";

}
