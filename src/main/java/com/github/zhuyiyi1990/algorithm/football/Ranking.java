package com.github.zhuyiyi1990.algorithm.football;

import java.util.*;

public class Ranking {

    // 当前赛季
    public static final String SEASON = "2024/25";

    // 英超
    public static final String PREMIER_LEAGUE = "Premier League";

    // 西甲
    public static final String LA_LIGA = "La Liga";

    // 意甲
    public static final String SERIE_A = "Serie A";

    // 德甲
    public static final String BUNDESLIGA = "Bundesliga";

    // 法甲
    public static final String LIGUE_1 = "Ligue 1";

    // 上赛季（2023/24）联赛排名
    public List<String> associationRankingList;

    // 上赛季（2023/24）俱乐部排名（加上升级球队）
    public Map<String, List<String>> clubRankingMap;

    public Ranking() {
        associationRankingList = new ArrayList<>();
        associationRankingList.add(PREMIER_LEAGUE);
        associationRankingList.add(SERIE_A);
        associationRankingList.add(LA_LIGA);
        associationRankingList.add(BUNDESLIGA);
        associationRankingList.add(LIGUE_1);

        clubRankingMap = new HashMap<>();

        // 英超 https://baike.baidu.com/item/2024-25%E8%B5%9B%E5%AD%A3%E8%8B%B1%E6%A0%BC%E5%85%B0%E8%B6%B3%E7%90%83%E8%B6%85%E7%BA%A7%E8%81%94%E8%B5%9B
        List<String> list = new ArrayList<>();
        list.add("曼城");
        list.add("阿森纳");
        list.add("利物浦");
        list.add("阿斯顿维拉");
        list.add("热刺");
        list.add("切尔西");
        list.add("纽卡斯尔");
        list.add("曼联");
        list.add("西汉姆联");
        list.add("水晶宫");
        list.add("布莱顿");
        list.add("伯恩茅斯");
        list.add("富勒姆");
        list.add("狼队");
        list.add("埃弗顿");
        list.add("布伦特福德");
        list.add("诺丁汉森林");
        list.add("卢顿");
        list.add("伯恩利");
        list.add("谢菲尔德联");
        // 升级球队
        list.add("莱斯特城");
        list.add("伊普斯威奇");
        list.add("南安普敦");
        clubRankingMap.put(PREMIER_LEAGUE, list);

        // 西甲 https://www.vipc.cn/article/66bc1dec710b34001915cb93
        list = new ArrayList<>();
        list.add("皇家马德里");
        list.add("巴塞罗那");
        list.add("赫罗纳");
        list.add("马德里竞技");
        list.add("毕尔巴鄂竞技");
        list.add("皇家社会");
        list.add("皇家贝蒂斯");
        list.add("比利亚雷亚尔");
        list.add("瓦伦西亚");
        list.add("阿拉维斯");
        list.add("奥萨苏纳");
        list.add("赫塔菲");
        list.add("维戈塞尔塔");
        list.add("塞维利亚");
        list.add("马略卡");
        list.add("拉斯帕尔马斯");
        list.add("巴列卡诺");
        list.add("加的斯");
        list.add("阿尔梅里亚");
        list.add("格拉纳达");
        // 升级球队
        list.add("莱加内斯");
        list.add("巴拉多利德");
        list.add("西班牙人");
        clubRankingMap.put(LA_LIGA, list);

        // 意甲 https://www.qiumiwu.com/news/1422825621516
        list = new ArrayList<>();
        list.add("国际米兰");
        list.add("AC米兰");
        list.add("尤文图斯");
        list.add("亚特兰大");
        list.add("博洛尼亚");
        list.add("罗马");
        list.add("拉齐奥");
        list.add("佛罗伦萨");
        list.add("都灵");
        list.add("那不勒斯");
        list.add("热那亚");
        list.add("蒙扎");
        list.add("维罗纳");
        list.add("莱切");
        list.add("乌迪内斯");
        list.add("卡利亚里");
        list.add("恩波利");
        list.add("弗罗西诺内");
        list.add("萨索洛");
        list.add("萨莱尼塔纳");
        // 升级球队
        list.add("帕尔马");
        list.add("科莫");
        list.add("威尼斯");
        clubRankingMap.put(SERIE_A, list);

        // 德甲 https://www.vipc.cn/article/66bec87cd5873c0020a3edbd?in=result_content
        list = new ArrayList<>();
        list.add("勒沃库森");
        list.add("斯图加特");
        list.add("拜仁慕尼黑");
        list.add("莱比锡");
        list.add("多特蒙德");
        list.add("法兰克福");
        list.add("霍芬海姆");
        list.add("海登海姆");
        list.add("不莱梅");
        list.add("弗赖堡");
        list.add("奥格斯堡");
        list.add("沃尔夫斯堡");
        list.add("美因茨");
        list.add("门兴");
        list.add("柏林联盟");
        list.add("波鸿");
        list.add("科隆");
        list.add("达姆施塔特");
        // 升级球队
        list.add("圣保利");
        list.add("荷尔斯泰因");
        clubRankingMap.put(BUNDESLIGA, list);

        // 法甲 https://baijiahao.baidu.com/s?id=1800810995139415114&wfr=spider&for=pc
        list = new ArrayList<>();
        list.add("巴黎圣日耳曼");
        list.add("摩纳哥");
        list.add("布雷斯特");
        list.add("里尔");
        list.add("尼斯");
        list.add("里昂");
        list.add("朗斯");
        list.add("马赛");
        list.add("兰斯");
        list.add("雷恩");
        list.add("图卢兹");
        list.add("蒙彼利埃");
        list.add("斯特拉斯堡");
        list.add("南特");
        list.add("勒阿弗尔");
        list.add("梅斯");
        list.add("洛里昂");
        list.add("克莱蒙");
        // 升级球队
        list.add("欧塞尔");
        list.add("昂热");
        list.add("圣埃蒂安");
        clubRankingMap.put(LIGUE_1, list);
    }

    public static void main(String[] args) throws Exception {
        Ranking ranking = new Ranking();

        List<String> teamList = Arrays.asList(
                "马德里竞技", "西班牙人", "皇家社会",
                "阿拉维斯", "巴拉多利德", "莱加内斯", "毕尔巴鄂竞技", "瓦伦西亚"
        );

        // 预检查
        for (String team : teamList) {
            boolean found = false;
            for (String association : ranking.associationRankingList) {
                List<String> clubList = ranking.clubRankingMap.get(association);
                if (clubList.contains(team)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("无此球队：" + team);
            }
        }

        // 查找
        for (String association : ranking.associationRankingList) {
            List<String> clubList = ranking.clubRankingMap.get(association);
            for (String club : clubList) {
                if (teamList.contains(club)) {
                    System.out.println("看" + club + "的比赛");
                    return;
                }
            }
        }
    }

}