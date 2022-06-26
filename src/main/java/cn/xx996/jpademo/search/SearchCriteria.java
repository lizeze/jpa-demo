package cn.xx996.jpademo.search;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @BelongsProject: jpa-demo
 * @BelongsPackage: cn.xx996.jpademo.search
 * @Author: lizeze
 * @CreateTime: 2022-06-26 16:26
 */
@Data
@AllArgsConstructor
public class SearchCriteria {

    private String key;
    private Object value;
    private SearchOperation operation;
}
