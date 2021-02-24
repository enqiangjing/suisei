<template>
	<div class="home">
		<nav class="primary-bg cc-display">
			<div class="search ec-display">
				<LoginInput type="search" class="input" v-model="searchInupt" placeholder="请输入搜索值" />
			</div>
			<div class="logo cc-display">
				<image src="/static/img/home/mlogo.svg" alt="" @click="fnGetAccountList" />
			</div>
		</nav>
		<MainList :msgList="accountList"></MainList>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				sonMenu: false,
				searchInupt: "",
				accountList: [],
				accountListCopy: [],
			};
		},
		methods: {
			// 账户信息查询
			fnGetAccountList() {
				if (this.$store.state.privateKey === "") {
					uni.showToast({
						title: '私钥未载入！',
						icon: 'none',
						duration: 2000,
					});
					return;
				}
				this.$rsa.setPrivateKey(
					"-----BEGIN RSA PRIVATE KEY-----" +
					this.$store.state.privateKey +
					"-----END RSA PRIVATE KEY-----"
				);
				// 查询加密数据列表
				uni.request({
					url: this.$baseUrl + 'api/getListLike', //仅为示例，并非真实接口地址。
					method: 'POST',
					data: {
						userName: this.$store.state.userName,
					},
					header: {
						'custom-header': 'uni-app-suisei' //自定义请求头信息
					},
					success: (res) => {
						if (res.data.errCode === 'success') {
							// 数据解密
							this.accountList = res.data.data.map((e) => {
								return {
									...e,
									account: this.$rsa.decrypt(e.account),
									extra: this.$rsa.decrypt(e.extra),
									password: this.$rsa.decrypt(e.password),
									systemName: this.$rsa.decrypt(e.systemName),
								};
							});
							console.log(this.accountList)
							this.accountListCopy = Object.assign({}, this.accountList);
							uni.showToast({
								title: '查询成功！',
								icon: 'none',
								duration: 2000,
							});
							return;
						}
						uni.showToast({
							title: res.data,
							icon: 'none',
							duration: 2000,
						});
					}
				});
			},
		}
	}
</script>

<style lang="less" scoped>
	// 菜单按钮背景
	@menu-bg: rgb(67, 148, 253);

	.home {
		position: relative;
		height: 100%;
		width: 100%;
		background: url(/static/logo.png) no-repeat top center;
		overflow: hidden;
		z-index: 1000;
		overflow-y: auto;
		overflow-y: overlay;
		overflow-x: auto;

		nav {
			width: 100%;
			height: 60px;
			position: relative;
			position: sticky;
			top: 0;
			z-index: 1100;

			.menu {
				position: absolute;
				right: 0;
				top: 0;
				height: 100%;
				width: 80px;

				image {
					width: 40px;
					height: 40px;

					&:hover {
						cursor: pointer;
						background-color: @menu-bg;
					}
				}

				.son-menu {
					position: absolute;
					right: 10px;
					top: 10px;
					width: 100px;
					padding: 10px 0;
					background-color: @menu-bg;
					box-shadow: 0 0 6px #aaa;
					z-index: 1200;

					.s-item {
						width: 100%;
						height: 50px;
						color: #fff;

						&:hover {
							background-color: rgb(101, 162, 243);
							cursor: pointer;
						}
					}
				}
			}

			.logo {
				height: 100%;
				width: 20%;

				image {
					width: 40px;
					height: 40px;
					cursor: pointer;
				}
			}

			.search {
				width: 80%;
				height: 100%;

				.input {
					width: 90%;
					height: 45px;
					background-color: #fff;
				}
			}
		}
	}
</style>
