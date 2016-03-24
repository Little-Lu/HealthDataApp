package com.joye.health.dao.emergency;

import java.util.List;

import com.joye.health.model.emergency.HeEventLocalePicture;


public interface IHeEventLocalePictureDao {
	public List<HeEventLocalePicture> queryHeEventLocalePicture();
	public int insertHeEventLocalePicture(HeEventLocalePicture heEventLocalePicture);
	public int updateHeEventLocalePicture(HeEventLocalePicture heEventLocalePicture);
	public int deleteHeEventLocalePicture(String pk);
}
