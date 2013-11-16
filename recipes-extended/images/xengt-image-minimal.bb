DESCRIPTION = "A minimal xen image"

INITRD_IMAGE = "core-image-minimal-initramfs"

IMAGE_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    kernel-module-xen-acpi-processor \
    kernel-module-xen-blkback \
    kernel-module-xen-blkfront \
    kernel-module-xen-evtchn \
    kernel-module-xenfs \
    kernel-module-xen-gntalloc \
    kernel-module-xen-gntdev \
    kernel-module-xen-netback \
    kernel-module-xen-netfront \
    kernel-module-xen-pciback \
    kernel-module-xen-pcifront \
    kernel-module-xen-privcmd \
    kernel-module-xen-wdt \
    xen-base \
    xen-qemu \
    "

LICENSE = "MIT"

inherit core-image

syslinux_iso_populate_append() {
	install -m 0444 ${STAGING_DATADIR}/syslinux/mboot.c32 ${ISODIR}${ISOLINUXDIR}
}

syslinux_hddimg_populate_append() {
	install -m 0444 ${STAGING_DATADIR}/syslinux/mboot.c32 ${HDDDIR}${SYSLINUXDIR}
}

grubefi_populate_append() {
	install -m 0644 ${DEPLOY_DIR_IMAGE}/xen-${MACHINE}.gz ${DEST}${EFIDIR}/xen.gz
}

populate_append() {
	install -m 0644 ${DEPLOY_DIR_IMAGE}/xen-${MACHINE}.gz ${DEST}/xen.gz
}

build_syslinux_cfg () {
	echo "ALLOWOPTIONS 1" > ${SYSLINUXCFG}
	echo "DEFAULT boot" >> ${SYSLINUXCFG}
	echo "TIMEOUT 10" >> ${SYSLINUXCFG}
	echo "PROMPT 1" >> ${SYSLINUXCFG}
	echo "LABEL boot" >> ${SYSLINUXCFG}
	echo "  KERNEL mboot.c32" >> ${SYSLINUXCFG}
	echo -n "  APPEND /xen.gz dom0_mem=2048M loglvl=all guest_loglvl=all console=com1 com1=115200,8n1 conring=4M" >> ${SYSLINUXCFG}
    echo -n "    --- /vmlinuz ramdisk_size=32768 root=/dev/ram0 rw console=hvc0 earlyprintk=xen console=tty0 panic=10 LABEL=boot debugshell=5 xen_vgt.hvm_boot_foreground=1" >> ${SYSLINUXCFG}
    echo    "    --- /initrd" >> ${SYSLINUXCFG}
}