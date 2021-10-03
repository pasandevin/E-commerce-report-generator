package com.kelaniya.uni.repository;

import java.util.ArrayList;

public interface DataRetriever {

    ArrayList<String[]> retrieve(String startDate, String endDate);

}
