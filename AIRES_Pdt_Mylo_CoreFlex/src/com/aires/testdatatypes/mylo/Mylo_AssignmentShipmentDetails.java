package com.aires.testdatatypes.mylo;

public class Mylo_AssignmentShipmentDetails {
	
	public String environment;
	public NoShipment noShipment;
	public OneShipment oneShipment;
	public TwoShipment twoShipment;
	public MultipleShipment multipleShipment;
	
	public class NoShipment {
		public String fileID;
		public String shipmentDetails;
	}
	public class OneShipment {
		public String fileID;
		public String shipmentDetails;
	}
	public class MultipleShipment {
		public String fileID;
		public String shipmentDetails;
	}
	public class TwoShipment {
		public String fileID;
		public String shipmentDetails;
	}

}
