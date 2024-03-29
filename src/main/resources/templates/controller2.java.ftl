package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import com.honger1234.springbootprojectseed.util.ResultGenerator;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




import javax.validation.Valid;
import java.util.List;

/**
* <p>
    * ${table.comment} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Api(tags = "${table.comment}")

@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @ApiOperation(value = "${table.comment}分页列表", response = ${entity}.class)
    @ApiImplicitParams({
    @ApiImplicitParam(name = "page", value = "页面", dataType = "Long"),
    @ApiImplicitParam(name = "size", value = "页面数据量", dataType = "Long"),
    @ApiImplicitParam(name = "sort", value = "排序方式排序[true:正序; false:倒序]", dataType = "Boolean"),
    @ApiImplicitParam(name = "sortName", value = "排序字段,参照返回字段", dataType = "String")})
    @PostMapping(value = "/page")
    public  Object list(@Valid @RequestBody ${entity} param,@RequestParam long page,@RequestParam long size) {
    Page<${entity}> objectPage = new Page<>(page, size);
    Object data = ${table.serviceName?uncap_first}.page(param,objectPage);
    return ResultGenerator.genSuccessResult(data);
    }

    @ApiOperation(value = "${table.comment}详情", response = ${entity}.class)
    @GetMapping(value = "/info/{id}")
    public  Object info(@PathVariable Long id) {

    Object data = ${table.serviceName?uncap_first}.info(id);
    return ResultGenerator.genSuccessResult(data);
    }

    @ApiOperation(value = "${table.comment}新增")
    @PostMapping(value = "/add")
    public  Object add(@Valid @RequestBody ${entity} param) {

    ${table.serviceName?uncap_first}.add(param);
    return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "${table.comment}修改")
    @PostMapping(value = "/modify")
    public  Object modify(@Valid @RequestBody ${entity} param) {

    ${table.serviceName?uncap_first}.modify(param);
    return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "${table.comment}删除(单个条目)")
    @GetMapping(value = "/remove/{id}")
    public  Object remove(@PathVariable Long id) {

    ${table.serviceName?uncap_first}.remove(id);
    return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "${table.comment}删除(多个条目)")
    @PostMapping(value = "/removes")
    public  Object removes(@Valid @RequestBody List<Long> ids) {

    ${table.serviceName?uncap_first}.removes(ids);
    return ResultGenerator.genSuccessResult();
    }

    }
</#if>