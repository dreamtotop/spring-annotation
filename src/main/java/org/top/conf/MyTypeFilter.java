package org.top.conf;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 包扫描自定义规则
 */
public class MyTypeFilter implements TypeFilter {

    /***
     *
     * @param metadataReader  读取当前正在扫描的类信息
     * @param metadataReaderFactory  可以获取到其他任何类信息
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取该扫描的类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取该扫描的类信息（类的类型，实现的接口等）
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取该扫描的类的资源信息（类路径等）
        Resource resource = metadataReader.getResource();
        // 获取扫描到的类名称
        String className = classMetadata.getClassName();
        System.out.println("--->"+ className);
        if(className.contains("Service")){
            return true;
        }
        return false;
    }
}
