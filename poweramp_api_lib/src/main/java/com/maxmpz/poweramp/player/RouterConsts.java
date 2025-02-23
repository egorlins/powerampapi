/*
Copyright (C) 2011-2021 Maksim Petrov

Redistribution and use in source and binary forms, with or without
modification, are permitted for widgets, plugins, applications and other software
which communicate with Poweramp application on Android platform.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE FOUNDATION OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.maxmpz.poweramp.player;

import org.eclipse.jdt.annotation.NonNull;
import android.annotation.TargetApi;
import android.media.AudioDeviceInfo;

public interface RouterConsts {
	// Sync with plugininterface-output.h
	public static final int DEVICE_HEADSET    = 0;
	public static final int DEVICE_SPEAKER    = 1;
	public static final int DEVICE_BT         = 2;
	public static final int DEVICE_USB        = 3;
	public static final int DEVICE_OTHER      = 4;
	public static final int DEVICE_CHROMECAST = 5;
	// 6

	public static final int DEVICE_UNKNOWN = 0xFF;

	//public static final int DEVICE_MASK    = 0xFF; // 256 devices

	public static final int DEVICE_COUNT   = 6;
	public static final int DEVICE_SAFE_DEFAULT = DEVICE_HEADSET;

	public static final @NonNull String DEVICE_NAME_HEADSET = "headset";
	public static final @NonNull String DEVICE_NAME_SPEAKER = "speaker";
	public static final @NonNull String DEVICE_NAME_BT = "bt";
	public static final @NonNull String DEVICE_NAME_USB = "usb";
	public static final @NonNull String DEVICE_NAME_OTHER = "other";
	public static final @NonNull String DEVICE_NAME_CHROMECAST = "chromecast";
	
	public final class Helper {
		private Helper() {}

		@TargetApi(23)
		public static int toAndroidDeviceType(int device) {
			switch(device) {
				default:
				case DEVICE_HEADSET:
					return AudioDeviceInfo.TYPE_WIRED_HEADSET; // 3
				case DEVICE_SPEAKER:
					return AudioDeviceInfo.TYPE_BUILTIN_SPEAKER; // 2
				case DEVICE_BT:
					return AudioDeviceInfo.TYPE_BLUETOOTH_A2DP; // 8
				case DEVICE_USB:
					return AudioDeviceInfo.TYPE_USB_DEVICE; // 11
				case DEVICE_CHROMECAST:
					return AudioDeviceInfo.TYPE_IP; // 20
			}
		}
		
		/** @return true if the device is a valid known device (excluding {@link #DEVICE_UNKNOWN}) */ 
		public static boolean isValidKnownDevice(int device) {
			return device >= 0 && device < DEVICE_COUNT;
		}
	}
}
