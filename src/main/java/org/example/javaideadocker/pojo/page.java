package org.example.javaideadocker.pojo;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class page<T> {

    //分页：当前页 总数 数据集
    private int index;
    private int count;
    private List<T> list;

    public page(int index, int count, List<T> list) {
        this.index = index;
        this.count = count;
        this.list = list;
    }
}
