require recipes-extended/images/xen-guest-image-minimal.bb

DESCRIPTION = "A xengt image"

IMAGE_FEATURES += "splash package-management x11-base x11-sato hwcodecs"

IMAGE_INSTALL += " \
    rsync \
    packagegroup-core-ssh-openssh \
    packagegroup-core-x11-sato-games \
    midori \
    "

SYSLINUX_KERNEL_ARGS += " xen_vgt.hvm_boot_foreground=1"
