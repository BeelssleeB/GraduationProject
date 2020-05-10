package com.ls.project.service;

import com.ls.project.utils.RespPageBean;

public interface ToolStreamService {

    RespPageBean getAllToolStream(String keyWord, Integer page, Integer size);
}
