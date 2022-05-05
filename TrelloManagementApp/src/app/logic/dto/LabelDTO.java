package app.logic.dto;

import app.db.entity.LabelEntity;

public class LabelDTO {
	private int sequence;
	private String address1;
	private String address2;
	private String label;
	
	public LabelDTO(int sequence, String address1, String address2, String label) {
		this.sequence = sequence;
		this.address1 = address1;
		this.address2 = address2;
		this.label = label;
	}
	
	public LabelDTO(LabelEntity labelEntity) {
		this.sequence = labelEntity.getSequence();
		this.address1 = labelEntity.getAddress1();
		this.address2 = labelEntity.getAddress2();
		this.label = labelEntity.getLabel();
	}
	
	public LabelEntity toLabelEntity() {
		LabelEntity labelEntity = new LabelEntity();
		labelEntity.setSequence(this.sequence);
		labelEntity.setAddress1(this.address1);
		labelEntity.setAddress2(this.address2);
		labelEntity.setLabel(this.label);
		return labelEntity;
	}
	
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
