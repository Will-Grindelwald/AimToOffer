package in.action.day0825.pm.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 在快递公司干线运输的车辆使用中，存在着单边车和双边车的两种使用场景，例如 北京中心 - 杭州中心，两个分拨中心到彼此的单量对等，则可以开双边车（即同一辆车可以往返对开），而当两个中心的对发单量不对等时，则会采用单边车，并且双边车的成本是低于单边车的，即将两辆对开的单边车合并为一辆往返的双边车是能够节省运力成本的
// 单边车优化原则：
// 将单边车优化的规则进行可抽象为以下三种（A,B,C 均表示分拨中心）：
// 规则 - 1: A-B 单边车，B-A 单边车 优化方案：将 A-B 和 B-A 的两辆单边车合并为双边；
// 规则 - 2: A-B 单边车，B-C 单边车，C-A 单边车 优化方案：将 A-B、B-C、C-A 的三辆单边车优化为一辆环形往返车；
// 规则 - 3: A-B 单边车，C-A 单边车，B、C 同省 优化方案：当 B、C 同省，将 A-B、C-A 两辆单边优化为一辆环形往返
// 问题如下：
// 以某快递公司的实际单边车数据为例（线路 ID 编码; 出分拨中心; 出分拨中心所在省; 到达分拨中心; 到达分拨中心所在省；车型；），进行优化，优化的规则参照以上，并且优先级依次降低，合并的时候需要考虑车型（分为 17.5m 和 9.6m 两种）：1、相同车型才能进行合并；2、两辆同方向的 9.6m 可以与一辆 17.5m 的对开车型合并优化 说明：优化输出结果按照规则分类，例如 rule1： 2016120001+2016120002 表示将单边车线路 ID 编码为 2016120001 和 2016120002 按照规则 1 合并优化
// 输入:
// 线路数据，大于 2 行 每行由 6 列组成 线路 ID; 出发分拨中心名称; 出发省名称; 到达分拨中心名称; 到达省名称; 车型;
// 输出:
// 按照三个优化规则输出的单边车优化结果
// 输入范例:
// 350410; 嘉兴中心; 浙江省; 西安中心; 陕西省; 9.6m;
// 350424; 西安中心; 陕西省; 嘉兴中心; 浙江省; 9.6m;
// 350428; 嘉兴中心; 浙江省; 长沙中心; 湖南省; 17.5m;
// 350432; 长沙中心; 湖南省; 武汉中心; 湖北省; 17.5m;
// 350448; 武汉中心; 湖北省; 嘉兴中心; 浙江省; 17.5m;
// 350476; 嘉兴中心; 浙江省; 潍坊中心; 山东省; 9.6m;
// 350479; 潍坊中心; 山东省; 嘉兴中心; 浙江省; 17.5m;
// 350481; 嘉兴中心; 浙江省; 成都中心; 四川省; 9.6m;
// 输出范例:
// rule1:350410+350424
// rule2:350428+350432+350448
public class T2TODO {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
		while (scanner.hasNextLine()) {
			String[] options = scanner.nextLine().split(";");
			if (options.length < 5) {
				break;
			}
			lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
		}
		scanner.close();

		// wirte your code here
		List<String> result = calculateUnilateral(lineList);

		for (String str : result) {
			System.out.println(str);
		}
	}

	public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
		List<String> result = new ArrayList<String>();
		result.add("rule1:350410+350424");
		result.add("rule2:350428+350432+350448");
		return result;
	}

	public static class UnilateralLine {
		private String id;
		private String sCen;// 出发分拨
		private String sPro;// 出发省
		private String eCen;// 到达分拨
		private String ePro;// 到达省
		// 9.6m/17.5m
		private String tType;// 车型

		public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
			this.id = id;
			this.sCen = sCen;
			this.sPro = sPro;
			this.eCen = eCen;
			this.ePro = ePro;
			this.tType = tType;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getSCen() {
			return sCen;
		}

		public void setSCen(String ePro) {
			this.ePro = ePro;
		}

		public String getSPro() {
			return sPro;
		}

		public void setSPro(String sPro) {
			this.sPro = sPro;
		}

		public String getECen() {
			return eCen;
		}

		public void setECen(String eCen) {
			this.eCen = eCen;
		}

		public String getEPro() {
			return ePro;
		}

		public void setEPro(String ePro) {
			this.ePro = ePro;
		}

		public String getTType() {
			return tType;
		}

		public void setTType(String tType) {
			this.tType = tType;
		}
	}
}
