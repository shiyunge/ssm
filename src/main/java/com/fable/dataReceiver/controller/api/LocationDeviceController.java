package com.fable.dataReceiver.controller.api;

import com.fable.common.bean.vo.ListResult;
import com.fable.common.bean.vo.ObjectResult;
import com.fable.dataReceiver.bean.po.LocationDevicePO;
import com.fable.dataReceiver.service.LocationDeviceService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 采集设备控制器
 *
 * @author syg
 */
@RestController
@RequestMapping("/api/locationDevice")
@Api(value = "采集设备信息", description = "采集设备信息")
public class LocationDeviceController {

    @Autowired
    private LocationDeviceService locationDeviceService;

    @RequestMapping(value = "/getByImei", method = RequestMethod.GET)
    @ApiOperation(value = "通过IMEI号获取设备", notes = "通过IMEI号获取设备")
    public ObjectResult<LocationDevicePO> getByImei(@ApiParam(required = true, value = "IMEI号") @RequestParam String imei) throws Exception {
        return new ObjectResult<>(true, HttpStatus.OK.toString(), "获取成功", locationDeviceService.getByImei(imei));
    }


    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ApiOperation(value = "条件查询", notes = "条件查询")
    public ListResult<LocationDevicePO> query(@ApiParam(required = true, value = "查询参数") @RequestBody Map<String, Object> params) {
        PageInfo<LocationDevicePO> pageInfo = locationDeviceService.query(params);
        return new ListResult<>(true, HttpStatus.OK.toString(), "查询成功", pageInfo.getPageNum(), pageInfo.getTotal(), pageInfo.getList());
    }
}
