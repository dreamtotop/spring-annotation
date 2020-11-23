package org.top.conf;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Import 的 第二种用法
 */
public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param annotationMetadata  当前类的注解信息
     * @return  返回值为导入到容器中的组件的全类名
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"org.top.bean.Student"};
    }
}
