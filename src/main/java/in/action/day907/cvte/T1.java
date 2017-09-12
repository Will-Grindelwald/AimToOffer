package in.action.day907.cvte;

/**
 * 
 * 解析 IPV4 IPV6 地址， 返回 IPv4 IPv6 Neither
 * 
 * IPv4 不允许前导 0，4 个数均在0~255
 * 
 * IPv6 允许前导 0，但不允许用连续“:”省略 0
 * 
 */
public class T1 {
	public static void main(String[] args) {
	}

	public String validIPAddress(String IP) {
		if (IP == null || IP.equals(""))
			return "Neither";
		if (IP.indexOf('.') != -1) {
			String[] nums = IP.split(".");
			if (nums.length != 4) {
				return "Neither";
			}
			for (int i = 0; i < 3; i++) {
				if (!(nums[i].charAt(0) - '0' >= 1 && nums[i].charAt(0) - '0' <= 9)) {
					return "Neither";
				}
				try {
					int num = Integer.valueOf(nums[i]);
					if (num < 0 || num > 255)
						return "Neither";
				} catch (Exception e) {
					return "Neither";
				}
			}
			return "IPv4";
		} else if (IP.indexOf(':') != -1) {
			String[] nums = IP.split(":");
			if (nums.length != 8) {
				return "Neither";
			}
			for (int i = 0; i < 8; i++) {
				if (nums[i].length() != 4)
					return "Neither";
				for (int j = 0; j < 4; j++) {
					if (!((nums[i].charAt(j) - '0' >= 0 && nums[i].charAt(j) - '0' <= 9)
							|| (nums[i].charAt(j) - 'A' >= 0 && nums[i].charAt(j) - 'A' <= 5)
							|| (nums[i].charAt(j) - 'a' >= 0 && nums[i].charAt(j) - 'a' <= 5))) {
						return "Neither";
					}
				}
			}
			return "IPv6";
		}
		return "Neither";
	}
}
