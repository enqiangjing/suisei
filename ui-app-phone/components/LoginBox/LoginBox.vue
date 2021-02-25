<template>
	<view class="box ce-display">
		<view class="outside" v-if="!isLogin">
			<view class="top cc-display">
				<image src="/static/img/login/user.svg" alt="top" />
			</view>
			<view class="item cs-display">
				<LoginInput type="email" class="input" v-model="userName" placeholder="请输入用户名" />
			</view>
			<view class="item cs-display">
				<LoginInput type="password" class="input" v-model="password" placeholder="请输入密码" />
			</view>
			<view class="item cc-display">
				<Button @click="fnLogin">登录</Button>
			</view>
		</view>
		<view class="outside" v-if="isLogin">
			<view class="top cc-display">
				<image src="/static/img/login/user.svg" alt="top" />
			</view>
			<view class="item cs-display">
				{{currentUser}}
			</view>
			<view class="item cc-display">
				<Button @click="fnLogOut">退出</Button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name: "Box",
		props: {
			msg: String,
		},
		data() {
			return {
				userName: "",
				password: ""
			};
		},
		computed: {
			isLogin() {
				return this.$store.state.isLogin;
			},
			currentUser() {
				return this.$store.state.userName;
			}
		},
		methods: {
			// 登录请求发送
			fnLogin() {
				let userName = this.userName;
				if (userName === "") {
					this.$message.run("用户名未输入！", "warning");
					return;
				}
				let password = this.password;
				if (password === "") {
					this.$message.run("密码未输入！", "warning");
					return;
				}
				// 请求发送
				uni.request({
					url: this.$baseUrl + 'login', //仅为示例，并非真实接口地址。
					method: 'POST',
					data: {
						userName: this.userName,
						password: this.password,
					},
					header: {
						'custom-header': 'uni-app-suisei' //自定义请求头信息
					},
					success: (res) => {
						if (res.data.errCode === 'success') {
							this.$store.commit('upUserInfo', res.data.data);
							this.$store.commit('upLogStatus', true);
							uni.showToast({
								title: '登录成功！',
								icon: 'success',
								duration: 2000,
							});
							return;
						}
						uni.showToast({
							title: '交易失败！',
							icon: 'none',
							duration: 2000,
						});
					}
				});
			},
			// 退出登录
			fnLogOut() {
				uni.request({
					url: this.$baseUrl + 'api/logout', //仅为示例，并非真实接口地址。
					method: 'POST',
					data: {
						userName: this.userName,
						password: this.password,
					},
					header: {
						'custom-header': 'uni-app-suisei' //自定义请求头信息
					},
					success: (res) => {
						console.log(res.data)
						if (res.data.errCode === 'success') {
							this.$store.commit('upUserInfo', {});
							this.$store.commit('upLogStatus', true);
							uni.showToast({
								title: '已退出！',
								icon: 'none',
								duration: 2000,
							});
							return;
						}
						uni.showToast({
							title: '交易失败！',
							icon: 'none',
							duration: 2000,
						});
					}
				});
			},
		},
	};
</script>

<style scoped lang="less">
	.box {
		width: 100%;
		height: 55%;

		.outside {
			width: 90%;
			height: 400px;
			background-color: rgba(255, 255, 255, 0.85);
			border-radius: 10px;

			.top {
				height: 50%;
				overflow: hidden;

				image {
					width: 140px;
					height: 140px;
					border-radius: 80px;
					background-color: #eee;
				}
			}

			.item {
				height: 15%;

				.input {
					width: 90%;
					height: 50px;
				}
			}
		}
	}
</style>
