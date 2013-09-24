FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
           file://linux-vgt.patch \
           "
