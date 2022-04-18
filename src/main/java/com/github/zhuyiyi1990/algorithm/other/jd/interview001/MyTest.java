package com.github.zhuyiyi1990.algorithm.other.jd.interview001;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest {

    public Map<Long, Collection<String>> fun(List<PurchaseRecord> purchaseRecords, List<Long> ids) {
        Map<Long, Map<String, Long>> map = purchaseRecords.stream().filter(purchaseRecord -> ids.contains(purchaseRecord.getId()))
                .collect(Collectors.groupingBy(PurchaseRecord::getId, Collectors.groupingBy(PurchaseRecord::getProduct, Collectors.counting())));
        return null;
    }

}