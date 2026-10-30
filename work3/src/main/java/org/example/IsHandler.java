package org.example;

import java.util.Map;

public interface IsHandler {
    public IsHandler addNext(IsHandler handler);
    public void work(String[] command, int[] memory, Map<String, Integer> registers);
}
