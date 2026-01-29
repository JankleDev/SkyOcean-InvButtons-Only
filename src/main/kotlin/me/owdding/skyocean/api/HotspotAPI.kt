package me.owdding.skyocean.api




object HotspotAPI {/*

    private val PARTICLE_COLOR = Vector3f(1.0f, 0.4117647f, 0.7058824f)

    private val _hotspots = mutableMapOf<Vector2d, HotspotData>()
    val hotspots: Collection<HotspotData> get() = _hotspots.values

    var lastHotspotFish = Instant.DISTANT_PAST
        private set

    @Subscription
    @OnlyOnSkyBlock
    fun onNameChanged(event: NameChangedEvent) {
        val pos = event.infoLineEntity.position()
        val type = HotspotType.getType(event.literalComponent) ?: return
        val hotspot = _hotspots.getOrPut(pos.toVec2d()) {
            HotspotData(id = event.infoLineEntity.id, type = type)
        }

        BlockPos.containing(pos).forEachBelow(3) {
            val fluid = McLevel[it].fluidState

            if (!fluid.isEmpty) {
                hotspot.pos = Vector3f(pos.x.toFloat(), it.y + fluid.getHeight(McLevel.self, it), pos.z.toFloat())
                HotspotEvent.Spawn(hotspot).post(SkyBlockAPI.eventBus)
                return
            }
        }
    }

    @Subscription
    fun onCatch(event: FishCatchEvent) {
        val hookY = event.hookPos.y
        val hookPosD = event.hookPos.toVector3f()
        _hotspots.values.filter {
            val y = it.pos?.y ?: return@filter false
            abs(hookY - y) < 3
        }.minByOrNull { it.pos?.distanceSquared(hookPosD) ?: Float.MAX_VALUE }?.let {
            it.fishedIn = true
            lastHotspotFish = currentInstant()
        }
    }

    @Subscription(ServerChangeEvent::class)
    fun onServerChange() = _hotspots.clear()

    @Subscription
    @OnlyOnSkyBlock
    fun onEntityRemoved(event: EntityRemovedEvent) {
        val pos = event.entity.position().toVec2d()
        val hotspot = _hotspots[pos] ?: return
        if (hotspot.id == event.entity.id) {
            _hotspots.remove(pos)
            HotspotEvent.Despawn(hotspot).post(SkyBlockAPI.eventBus)
        }
    }


    @Subscription
    @OnlyOnSkyBlock
    fun onParticle(event: PacketReceivedEvent) {
        val packet = event.packet as? ClientboundLevelParticlesPacket ?: return
        if (!packet.isHotSpotParticle()) return

        val maxHotspotSize = when (LocationAPI.island) {
            SkyBlockIsland.CRIMSON_ISLE -> 25.0
            else -> 9.0
        }

        for (entry in _hotspots.values) {
            if (entry.pos == null) continue

            val distance = ((packet.x - entry.pos!!.x).pow(2) + (packet.z - entry.pos!!.z).pow(2))
            if (distance <= maxHotspotSize + 0.5) {
                entry.radius = sqrt(distance).roundToHalf()
                // Hotspot particles are cancelled here to avoid having to check them again inside the HotspotFeatures object.
                if (HotspotFeatures.isEnabled()) event.cancel()
                return
            }
        }
    }

    private fun ClientboundLevelParticlesPacket.isHotSpotParticle(): Boolean {
        if (LocationAPI.island == SkyBlockIsland.CRIMSON_ISLE) {
            return this.particle.type == ParticleTypes.SMOKE && (this.count == 5 || this.count == 2)
        }
        val options = this.particle as? DustParticleOptions ?: return false
        return options.color == PARTICLE_COLOR
    }

    private fun Vec3.toVec2d(): Vector2d = Vector2d(this.x, this.z)
}

data class HotspotData(
    internal val id: Int,
    val type: HotspotType,
    var pos: Vector3f? = null,
    var radius: Double? = null,
    var fishedIn: Boolean = false,
)

enum class HotspotType(val color: Color, @Language("regexp") regex: String) {
    SEA_CREATURE(MinecraftColors.DARK_AQUA, "\\+\\d+α Sea Creature Chance"),
    FISHING_SPEED(MinecraftColors.AQUA, "\\+\\d+☂ Fishing Speed"),
    DOUBLE_HOOK(MinecraftColors.BLUE, "\\+\\d+⚓ Double Hook Chance"),
    TREASURE(MinecraftColors.GOLD, "\\+\\d+⛃ Treasure Chance"),
    TROPHY_FISH(MinecraftColors.GOLD, "\\+\\d+♔ Trophy Fish Chance"),
    UNKNOWN(MinecraftColors.LIGHT_PURPLE, ""),
    ;

    private val displayName = toFormattedName()
    val displayComponent: Component = displayName.asComponent { this.color = this@HotspotType.color.value }
    override fun toString(): String = displayName

    val regex: Regex = Regex(regex)

    companion object {

        fun getType(input: String): HotspotType? {
            for (type in entries) {
                if (type == UNKNOWN) continue
                if (type.regex.matches(input)) return type
            }
            return null
        }
    }
*/}
