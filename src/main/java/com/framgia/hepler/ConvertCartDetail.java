package com.framgia.hepler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.framgia.bean.CartDetailInfo;
import com.framgia.model.CartDetail;

public class ConvertCartDetail {
	public static List<CartDetailInfo> listCartDetailToListCartDetailInfo(List<CartDetail> list) {

		try {
			List<CartDetailInfo> infos = new ArrayList<CartDetailInfo>();
			for (CartDetail cartDetail : list) {
				CartDetailInfo cartDetailInfo = new CartDetailInfo();
				BeanUtils.copyProperties(cartDetail, cartDetailInfo);
				infos.add(cartDetailInfo);
			}
			return infos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static CartDetailInfo cartDetailToCartDetailInfo(CartDetail cartDetail) {
		CartDetailInfo cartDetailInfo = new CartDetailInfo();
		BeanUtils.copyProperties(cartDetail, cartDetailInfo);
		return cartDetailInfo;
	}

	public static CartDetail cartDetailInfoToCartDetail(CartDetailInfo cartDetailInfo) {
		CartDetail cartDetail = new CartDetail();
		BeanUtils.copyProperties(cartDetailInfo, cartDetail);
		return cartDetail;
	}

}