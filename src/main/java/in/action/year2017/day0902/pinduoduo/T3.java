package in.action.year2017.day0902.pinduoduo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * 
 */
// 没做出来, 下面的代码是chdc的, 也跑不了
class Good {
	private int id;
	private int quantity;
	private int popularity;

	public Good(int id, int quantity, int popularity) {
		this.id = id;
		this.quantity = quantity;
		this.popularity = popularity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
}

class Activity {
	private int id;
	private int startTime;
	private int endTime;
	private int goodId;
	private int limitQuantity;

	public Activity(int id, int startTime, int endTime, int goodId, int limitQuantity) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.goodId = goodId;
		this.limitQuantity = limitQuantity;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public int getLimitQuantity() {
		return limitQuantity;
	}

	public void setLimitQuantity(int limitQuantity) {
		this.limitQuantity = limitQuantity;
	}
}

class Seckill {

	Map<Integer, Activity> activities = new HashMap<>();
	Map<Integer, Good> goods = new HashMap<>();

	public void addGood(int id, int quantity, int popularity) {
		Good good = new Good(id, quantity, popularity);
		goods.put(id, good);
	}

	private static int currentId = 0;

	public static int newActivityId() {
		return currentId++;
	}

	public int currentTime() {
		return 0; // 题目中未提及当前时间
	}

	public int addActivity(int startTime, int endTime, int goodId, int limitQuantity) {
		if (endTime <= startTime || limitQuantity <= 0) // || startTime < new
														// Date().getTime())
			return -1;

		Good good = goods.get(goodId);
		if (good == null || good.getQuantity() < limitQuantity)
			return -1;
		int aid = newActivityId();
		Activity activity = new Activity(aid, startTime, endTime, goodId, limitQuantity);
		activities.put(aid, activity);
		return aid;
	}

	public int buyGoods(int activityId, int quantity) {
		Activity activity = activities.get(activityId);
		if (activity == null || quantity <= 0)
			return -1;
		int now = currentTime();
		if (activity.getStartTime() > now || activity.getEndTime() < now || activity.getLimitQuantity() < quantity)
			return -1;
		Good good = goods.get(activity.getGoodId());
		if (good == null || good.getQuantity() < quantity)
			return -1;
		good.setQuantity(good.getQuantity() - quantity);
		return 0;
	}

	public void getActivityList() {
		// 进行中（未卖完） > 进行中（已卖完） > 未开始
		List<Activity> runing1 = new ArrayList<>();
		List<Activity> runing2 = new ArrayList<>();
		List<Activity> unstart = new ArrayList<>();

		for (Map.Entry<Integer, Activity> entry : activities.entrySet()) {

			Activity activity = entry.getValue();
			if (activity.getEndTime() < currentTime())
				continue; // 已结束

		}
	}

}

public class T3 {

	public static void main(String[] args) {

	}
}
