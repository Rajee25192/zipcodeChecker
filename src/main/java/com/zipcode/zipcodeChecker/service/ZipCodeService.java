package com.zipcode.zipcodeChecker.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zipcode.zipcodeChecker.Repository.ValidatedRepository;
import com.zipcode.zipcodeChecker.entity.ValidateZipCode;
import com.zipcode.zipcodeChecker.entity.ZipCodes;

@Service
public class ZipCodeService {

	@Autowired
	private ValidatedRepository validateRepo;
	/**
	 * @param arr
	 */
	public void mergeZipcodes(ZipCodes arr[]) {
		if (arr.length <= 0) 
			return; 
	
		Stack<ZipCodes> stack=new Stack<>(); 
	
		Arrays.sort(arr,new Comparator<ZipCodes>(){ 
			public int compare(ZipCodes i1,ZipCodes i2) 
			{ 
				return i1.getMinRange()-i2.getMinRange(); 
			} 
		}); 
	
		stack.push(arr[0]); 
	
		for (int i = 1 ; i < arr.length; i++) 
		{ 
			ZipCodes top = stack.peek(); 
	
			if (top.getMaxRange() < arr[i].getMinRange()) 
				stack.push(arr[i]); 
	
			else if (top.getMaxRange() < arr[i].getMaxRange()) 
			{ 
				top.setMaxRange(arr[i].getMaxRange()); 
				stack.pop(); 
				stack.push(top); 
			} 
		} 
	
		System.out.print("The merged zipcodes are: "); 
		validateRepo.deleteAll();
		
		while (!stack.isEmpty()) 
		{ 
			ZipCodes t = stack.pop();
			ValidateZipCode v = new ValidateZipCode(t.getMaxRange(),t.getMinRange());
			
			validateRepo.save(v);
			System.out.print("["+t.getMinRange()+","+t.getMaxRange()+"] "); 
		} 
	}
}