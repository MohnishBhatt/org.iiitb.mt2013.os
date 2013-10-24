package org.iiitb.model.bean;

import java.util.HashMap;
import java.util.Map;

import org.iiitb.controller.util.DiskVisualiser;

public class Disk {
	
	Map<Integer,Cylinder> diskobj ;
	
	public Disk(int numOfCylinders,int numOfSectors,int sizeOfSector){
		diskobj = new HashMap<Integer, Cylinder>();
		for(int i = 0; i< numOfCylinders;i++){
			Cylinder cyl = new Cylinder(i, numOfSectors, sizeOfSector);
			diskobj.put(i,cyl);
		}
		
	}

	public Map<Integer, Cylinder> getDiskobj() {
		return diskobj;
	}

	public void setDiskobj(Map<Integer, Cylinder> diskobj) {
		this.diskobj = diskobj;
	}
	
	public boolean occupySector(int cylinder,int sector){
		
		Sector temp= diskobj.get(cylinder).getCylinderobj().get(sector);
		if(!temp.isInUse()){
			temp.setInUse(true);
			DiskVisualiser.setContent("Adding Sector "+sector+" to cylinder "+cylinder);
			return true;
		}
		return false;
		
	}
	
	public boolean releaseSector(int cylinder,int sector){
		Sector temp= diskobj.get(cylinder).getCylinderobj().get(sector);
		if(temp.isInUse()){
			temp.setInUse(false);
			DiskVisualiser.setContent("Removing Sector "+sector+" from cylinder "+cylinder);
			return true;
		}
		return false;
	}
	
	

}