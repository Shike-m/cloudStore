package com.store.order.utils;
/*
 *  Created by Shike
 *  2018/8/22:16:40
 **/

import com.store.order.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("success");
        resultVO.setData(object);
        return resultVO;
    }
}
