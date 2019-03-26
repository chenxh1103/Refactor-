package org.chenxh.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.chenxh.web.entity.Chapter;

public interface ChapterMapper extends BaseMapper<Chapter> {

    @Select("select IFNULL(Max(sort_id),0) as sortId from Chapter where book_id = ${id}")
    Integer selectMaxSortIdByBookId(@Param("id")int bookId);

}
