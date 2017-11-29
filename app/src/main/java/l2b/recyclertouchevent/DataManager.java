package l2b.recyclertouchevent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by link on 2017/10/19 : 37.
 * email : libingyang119@163.com
 */

public class DataManager {
    private static List<Bean> mList;
    private static List<Integer> mInts = Arrays.asList(R.drawable.ic_fruit_icons_01, R.drawable.ic_fruit_icons_02,
            R.drawable.ic_fruit_icons_03, R.drawable.ic_fruit_icons_04,
            R.drawable.ic_fruit_icons_05, R.drawable.ic_fruit_icons_06);
    private static List<String> mStrings = Arrays.asList("苹果", "香蕉", "草莓", "冻梨", "芒果", "樱桃");

    public static List<Bean> getData(int number) {
        mList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Bean bean = new Bean(mStrings.get(i % (mStrings.size())), mInts.get(i % mInts.size()));
            mList.add(bean);
        }
        return mList;
    }
}
