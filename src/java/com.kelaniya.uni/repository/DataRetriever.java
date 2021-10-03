package com.kelaniya.uni.repository;

import java.util.ArrayList;

public interface DataRetriever {
    public ArrayList<String[]> retrieve(String startDate, String endDate);
}
