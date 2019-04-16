package com.fable.dataReceiver.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.fable.common.bean.vo.ListResult;
import com.fable.common.bean.vo.ObjectResult;
import com.fable.dataReceiver.bean.po.LocationDevicePO;
import com.fable.dataReceiver.service.ContentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "条件查询", notes = "条件查询")
    public ListResult<LocationDevicePO> query(@ApiParam(required = true, value = "查询条件") @RequestBody Map<String, Object> params) throws Exception {
        return new ListResult<>(true, HttpStatus.OK.toString(), "获取成功", contentService.getContentList(params));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "设备编号", notes = "设备编号")
    public ObjectResult get(@ApiParam(required = true, value = "设备编号") @RequestParam String imei) throws Exception {
        return new ObjectResult<>(true, HttpStatus.OK.toString(), "获取成功", contentService.get(imei));
    }

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    @ApiOperation(value = "设备编号", notes = "设备编号")
    public ObjectResult map() throws Exception {
        return new ObjectResult(true, HttpStatus.OK.toString(), "获取成功", contentService.map());
    }

}
