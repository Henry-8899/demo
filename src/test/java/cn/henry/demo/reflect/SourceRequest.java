package cn.henry.demo.reflect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Log
public class SourceRequest {
    public Integer sourceType;
    private Integer sourceId;

    int getMax(){
        return 1;
    }

    @Log
    public int getMin(int defaultValue, String... intArray) {
        System.out.println(String.format("[getMain] in; defaultValue : %d ;intArray : %s", defaultValue, intArray));
        return -1;
    }

    int getDate(Date date) {
        return -1;
    }
}
