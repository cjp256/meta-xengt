require recipes-extended/images/xen-guest-image-minimal.bb

DESCRIPTION = "A xengt image"

IMAGE_FEATURES += "splash package-management x11-base x11-sato hwcodecs tools-debug tools-testapps"

IMAGE_INSTALL += " \
    packagegroup-core-x11-sato-games \
    packagegroup-core-tools-testapps \
    rsync \
    packagegroup-core-ssh-openssh \
    midori \
    mesa-demos \
    supertux2 \
    pingus \
    evtest \
    gstreamer \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-ugly \
    gstreamer-vaapi \
    v4l-utils \
    intel-gpu-tools \
    etr \
    libtool libgcrypt gst-plugins-bad libsdl2 libsdl qt4-x11-free dbus libxml2 gnutls tremor faad2 gst-ffmpeg flac libxpm fluidsynth alsa-lib \
    "

SYSLINUX_KERNEL_ARGS += " xen_vgt.hvm_boot_foreground=1"

#NOHDD="1"
