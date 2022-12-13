package com.test.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component//被注解的类将成为spring上下文的一个组件Bean  （spring.xml启动了这个类也启动了）
@Aspect//被注解的类将成为一个通知类
public class PageAspect {
    @Around(value="execution(* *..*ServiceImpl.*Page(..))")
    public Object invoke(ProceedingJoinPoint joinPoint)throws  Throwable{
        //获取目标方法的执行参数
        Object[] args = joinPoint.getArgs();
        //定义PageBean对象
        PageBean pageBean=null;
        //循环遍历参数
        for (Object arg : args) {
            if(arg instanceof  PageBean){
                pageBean=(PageBean)arg;
                break;
            }
        }
        //判断是否分页，并设置分页参数到PageHelper中
        if(null!=pageBean&&pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        }
            //执行目标方法
            Object result = joinPoint.proceed(args);
            //获取分页信息
        if(null!=pageBean&&pageBean.isPagination()&&null!=result&&result instanceof List){
            List list=(List)result;
            PageInfo pageInfo=new PageInfo(list);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return result;

    }
}