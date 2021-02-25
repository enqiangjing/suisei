<template>
	<view class="main cc-display">
		<view class="no-data cc-display common-bg-r85 br-20" v-if="list.length === 0">
			<image src="/static/img/details/no_data.svg" alt="无数据" />
			<span class="fs-20 ls-8">还没有账号数据~~~</span>
		</view>
		<view class="ul" v-else>
			<view v-for="(item, index) in list" :key="item.id" class="common-bg-r85 br-8 li">
				<image class="edit" src="/static/img/home/edit.svg" alt="修改" @click="fnToEdit(item)" />
				<view class="item cc-display">
					<view class="left ec-display fs-14 fw-6">系统名：</view>
					<view class="right sc-display fs-14">
						{{ item.systemName }}
					</view>
				</view>
				<view class="item cc-display">
					<view class="left ec-display fs-14 fw-6">用户号：</view>
					<view class="right sc-display fs-14">
						{{ item.account }}
						<image src="/static/img/home/copy.svg" data-clipboard-action="copy" :class="'userName' + item.id"
						 :data-clipboard-text="item.account" @click="copyLink('userName' + item.id)" />
					</view>
				</view>
				<view class="item cc-display">
					<view class="left ec-display fs-14 fw-6">密码：</view>
					<view class="right sc-display fs-14">
						{{ item.password.charAt(0) + "******" + item.password.charAt(item.password.length - 1) }}
						<image src="/statix/img/home/copy.svg" data-clipboard-action="copy" :class="'password' + item.id"
						 :data-clipboard-text="item.password" @click="copyLink('password' + item.id)" />
					</view>
				</view>
				<view class="item cc-display">
					<view class="left ec-display fs-14 fw-6">其他信息：</view>
					<view class="right sc-display fs-14">{{ item.extra }}</view>
				</view>
			</view>
			<view class="common-bg-r85 br-8 li"></view>
		</view>
	</view>
</template>

<script>
	export default {
		name: "MainList",
		props: ["msgList"],
		data() {
			return {
				list: [],
			};
		},
		created() {
			this.list = this.msgList;
		},
		methods: {
			// 复制
			copyLink(val) {
				let _this = this;
				let clipboard = new this.$clipboard("." + val);
				clipboard.on("success", function() {
					_this.$message.run("复制成功");
				});
				clipboard.on("error", function() {
					_this.$message("复制失败", "error");
				});
			},

			// edit
			fnToEdit(item) {
				this.$store.commit('upEditItem', item);
				this.$store.commit('upEditStatus', true);
				uni.switchTab({
					url: '/pages/edit/edit'
				});
			},
		},
		watch: {
			msgList(newVal) {
				this.list = newVal;
			},
		},
	};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
	.main {
		width: 100%;

		.ul {
			width: 90%;

			.li {
				position: relative;
				height: 120px;
				margin-top: 30px;
				box-shadow: 0 0 4px #999;
				background-image: url("/static/img/home/bk/world.svg"),
					url("/static/img/home/bk/home.svg");
				background-position: 10px 10px, right bottom;
				background-repeat: no-repeat, no-repeat;
				background-size: 40px, 60px;
				padding: 10px 0;

				.edit {
					position: absolute;
					top: 10px;
					right: 10px;
					height: 20px;
					width: 20px;

					&:hover {
						cursor: pointer;
						box-shadow: 0 0 6px #999;
					}
				}
			}
		}
	}

	.item {
		width: 100%;
		height: 25%;

		.left {
			width: 40%;
			height: 100%;
		}

		.right {
			width: 60%;
			height: 100%;

			image {
				margin-left: 10px;
				width: 20px;
				height: 20px;

				&:hover {
					cursor: pointer;
					box-shadow: 0 0 6px #999;
				}
			}
		}
	}

	.no-data {
		margin-top: 30px;
		width: 90%;
		height: 200px;
		box-shadow: 0 0 6px #999;
		color: #409eff;

		image {
			width: 30px;
			height: 30px;
			margin-right: 10px;
		}
	}
</style>
