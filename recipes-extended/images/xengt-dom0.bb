require recipes-extended/images/xen-image-minimal.bb

DESCRIPTION = "xengt testing image"

IMAGE_FEATURES += "splash package-management x11-base x11-sato hwcodecs"

IMAGE_INSTALL += " \
    packagegroup-core-x11-sato-games \
    packagegroup-core-tools-testapps \
    "

SYSLINUX_XEN_ARGS += " conring_size=4M dom0_mem=2048M"
SYSLINUX_KERNEL_ARGS += " xen_vgt.hvm_boot_foreground=1"

