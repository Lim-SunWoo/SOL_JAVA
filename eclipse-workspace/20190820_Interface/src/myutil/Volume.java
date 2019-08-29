package myutil;

public interface Volume {
	int MIN_VOLUME = 0;
	int MAX_VOLUME = 50;

	void volumeUp();

	void volumeDown();

	void VolumeZero();
}