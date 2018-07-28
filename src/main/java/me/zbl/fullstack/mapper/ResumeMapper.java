package me.zbl.fullstack.mapper;

import me.zbl.fullstack.entity.Resume;
import me.zbl.fullstack.framework.mapper.IMyMapper;

/**
 * Resume
 *
 * @author raviteja
 */
public interface ResumeMapper extends IMyMapper<Resume> {

  String COLUMN_LIST = "resume.id,title,introduction,resume.gmt_create AS gmtCreate,resume.gmt_modified AS gmtModified";
}