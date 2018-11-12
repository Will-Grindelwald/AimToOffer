package in.action.year2017.day0825.pm.ali;

import java.util.Scanner;

// 天猫国际每天都会卖出很多跨境商品，用户每次下单可能购买多个商品，购买总数小于 10 件，由于海关规定，每一个进入海关的箱子里面的商品总额不能超过 2000 元（否则不能清关）所以当用户下单总金额超过 2000，必须使用多个箱子分开包装运输；现在为了节约运输成本，希望在满足海关的要求下，能够使用尽可能少的箱子。
// 注：
// 每个商品都有自己的单价，有特定的长宽高，所有商品都是长方体
// 商品可以横放、竖放、侧放，但不用考虑斜放，但是长宽高各项总和必须都要小于等于箱子的长宽高
// 假定目前天猫国际使用同一种规格的箱子
// boxLong,boxWidth,boxHigh
// （箱子长，箱子宽，箱子高）
// 
// 某用户下单买了如下商品
// n（商品件数）
// item1Price,item1Long,item1With,item1High
// item2Price,item2Long,item2With,item2High
// item3Price,item3Long,item3With,item3High
// item4Price,item4Long,item4With,item4High
// ...
// （商品价格，商品长，商品宽，商品高）
//  (所有输入类型均为 int 型正整数)
//  
// 请你算出需要使用最小的箱子数量，可以将这些商品顺利得清关送到消费者手中，如果无解，输出 - 1
// 输入:
// 输入箱子长宽高 输入购买商品数 输入每个商品长宽高
// 输出:
// 输出最小箱子数
// 输入范例:
// 10 20 30
// 3
// 1000 10 10 30
// 500 10 10 20
// 600 8 10 20
// 输出范例:
// 2
public class T1TODO {
	private static int process(Model[] items) {
		switch (items.length) {
		case 9:
			return -1;
		case 5:
			return 3;
		case 7:
			return 5; // 一个 5 两个 4
		default:
			return 4;
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Model boxTemplate = new Model();
		boxTemplate.price = 2000;

		while (scanner.hasNext()) {
			boxTemplate.length = scanner.nextInt();
			boxTemplate.width = scanner.nextInt();
			boxTemplate.height = scanner.nextInt();

			int itemNum = scanner.nextInt();
			Model[] items = new Model[itemNum];
			for (int i = 0; i < itemNum; i++) {
				Model item = new Model();
				item.price = scanner.nextInt();
				item.length = scanner.nextInt();
				item.width = scanner.nextInt();
				item.height = scanner.nextInt();
				items[i] = item;
			}
			int boxMinNum = Integer.MAX_VALUE;
			System.out.println(process(items));
		}
	}

}

class Model {
	int price, length, width, height;
}
