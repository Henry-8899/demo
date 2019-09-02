package cn.henry.demo.reflect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Log
public class SourceRequest {
    public Integer sourceType;
    private Integer sourceId;

    Integer getMax(){
        return 1;
    }
}
