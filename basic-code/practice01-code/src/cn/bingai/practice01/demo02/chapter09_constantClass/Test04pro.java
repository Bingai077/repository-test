package cn.bingai.practice01.demo02.chapter09_constantClass;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 *
 * @author bingai
 * @create 2019-11-03 9:53
 */
public class Test04pro {
    @Test
    public void test() {
        String str1 = "abcwerthelloyuiodefhellohelloohelloohelloohelloohelloohelloohelloo";
        String str2 = "abcwerhelloo";
        String[] arr = getMaxSameSubString1(str1, str2);
        System.out.println(Arrays.toString(arr));
    }


    //有一个最大子串
    private String maxStr(String str1, String str2) {
        if(str1 != null && str2 != null){
            String strMin = (str1.length() <= str2.length()) ? str1 : str2;
            String strMax = (str1.length() > str2.length()) ? str1 : str2;


            for (int i = 0; i < strMin.length(); i++) {
                for (int j = 0, k = strMin.length() - i; k <= strMin.length(); j++,k++) {
                    String temp = strMin.substring(j,k);
                    if(strMax.contains(temp)){
                        return temp;
                    }
                }

            }
        }
        return null;
    }

    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameSubString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
                //System.out.println(sBuffer);
                //重点
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }

        return null;
    }


     //如果存在多个长度相同的最大相同子串：使用ArrayList
	public List<String> getMaxSameSubString2(String str1, String str2) {
		if (str1 != null && str2 != null) {
			List<String> list = new ArrayList<String>();
			String maxString = (str1.length() > str2.length()) ? str1 : str2;
			String minString = (str1.length() > str2.length()) ? str2 : str1;

			int len = minString.length();
			for (int i = 0; i < len; i++) {
				for (int x = 0, y = len - i; y <= len; x++, y++) {
					String subString = minString.substring(x, y);
					if (maxString.contains(subString)) {
						list.add(subString);
					}
				}
				//重点
				if (list.size() != 0) {
					break;
				}
			}
			return list;
		}

		return null;
	}
}
