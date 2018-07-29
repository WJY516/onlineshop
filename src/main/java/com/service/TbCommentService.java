package com.service;

import com.domain.TbComment;

public interface TbCommentService {
	public TbComment selectCommentByUserName();
	public TbComment selectCommentByGoodsId();

}
