package com.employee.populator;

import java.util.List;

import com.employee.model.EmployeeAddress;

public class PersistableEmployeeAddressPopulator {
	
	public List<EmployeeAddress> populate(PersistableEmployeeAddress source,List<EmployeeAddress> target){
		
		List<PersistableAddressEmployee> empAddr = source.getAddresses();
		
		
		for(PersistableAddressEmployee pae: empAddr) {
			
			for(EmployeeAddress ea: target) {
				if(ea.getAddress()==pae.getId()) {
					ea.setAddressType(pae.getAddressType());
				}
			}
		}
		return target;
	}

}
