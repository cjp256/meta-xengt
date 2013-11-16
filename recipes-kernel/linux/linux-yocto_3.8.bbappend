FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "${@base_contains('DISTRO_FEATURES', 'xengt', ' file://linux-vgt.patch', '',d)}"
