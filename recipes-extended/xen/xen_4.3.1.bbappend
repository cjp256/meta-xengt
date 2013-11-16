FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "${@base_contains('DISTRO_FEATURES', 'xengt', ' file://xen-vgt.patch', '',d)}"
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'xengt', ' file://qemu-vgt.patch', '',d)}"
