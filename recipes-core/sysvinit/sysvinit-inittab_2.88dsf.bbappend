do_install_append() {
	if echo "${DISTRO_FEATURES}" | grep -q 'xengt'; then
		echo "" >> ${D}${sysconfdir}/inittab
		echo "2:12345:respawn:/usr/lib/xen/bin/qips debug-qips" >> ${D}${sysconfdir}/inittab
		sed -i '/ttyS0/d' ${D}${sysconfdir}/inittab
	fi
}
