FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://xen-vgt.patch \
            file://qemu-vgt.patch \            
            "
