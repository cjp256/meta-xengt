FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://vgt.rules \
            "

do_install_append() {
    install -m 0644 ${WORKDIR}/vgt.rules         ${D}${sysconfdir}/udev/rules.d/vgt.rules
}

