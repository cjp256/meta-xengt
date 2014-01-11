FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "${@base_contains('DISTRO_FEATURES', 'xengt', ' file://xen-vgt.patch', '',d)}"
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'xengt', ' file://qemu-vgt.patch', '',d)}"
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'xengt', ' file://qips.patch', '',d)}"
SRC_URI += " file://ps2-queue-size.patch "

FILES_${PN}-base += "/usr/lib/xen/bin/qips"

do_install_append() {
    echo "d root root 0755 /var/run/qips none" \
        >> ${D}${sysconfdir}/default/volatiles/99_xen
}
