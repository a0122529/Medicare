package com.neu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "vitalSign")
public class VitalSign {

	final static Logger logger = Logger.getLogger(VitalSign.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vitalId;

	private long timeStamp;

	private int respRate;

	private float weight;

	private float glucoseLevel;

	private float height;

	private String bp;

	private float bmi;

	private float pulse;

	private String onsetSymptoms;

	private String skinCondition;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "encounterId")
	private Encounter encounter;

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public int getRespRate() {
		return respRate;
	}

	public void setRespRate(int respRate) {
		this.respRate = respRate;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getGlucoseLevel() {
		return glucoseLevel;
	}

	public void setGlucoseLevel(float glucoseLevel) {
		this.glucoseLevel = glucoseLevel;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public float getPulse() {
		return pulse;
	}

	public void setPulse(float pulse) {
		this.pulse = pulse;
	}

	public int getVitalId() {
		return vitalId;
	}

	public void setVitalId(int vitalId) {
		this.vitalId = vitalId;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getBmi() {
		return bmi;
	}

	public void setBmi(float bmi) {
		this.bmi = bmi;
	}

	public String getOnsetSymptoms() {
		return onsetSymptoms;
	}

	public void setOnsetSymptoms(String onsetSymptoms) {
		this.onsetSymptoms = onsetSymptoms;
	}

	public String getSkinCondition() {
		return skinCondition;
	}

	public void setSkinCondition(String skinCondition) {
		this.skinCondition = skinCondition;
	}

}
