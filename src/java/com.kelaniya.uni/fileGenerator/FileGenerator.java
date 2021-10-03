package com.kelaniya.uni.fileGenerator;

import java.io.IOException;
import java.util.List;

public interface FileGenerator {

    public void generate(List<String[]> csvData) throws IOException;

}
